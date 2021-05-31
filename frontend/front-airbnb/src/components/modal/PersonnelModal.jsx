import React, {useState,useReducer} from 'react';
import styled from 'styled-components';
import { FaPlus, FaMinus } from "react-icons/fa";


function personnelReducer(guestInfo, category) {
    console.log('feefewf')
    let newArr = [...guestInfo];
    switch(category.id) {
        case '1':
            newArr[0].input++;
            console.log(category.id)
            return newArr;
        case '2':
            newArr[1].input++;
            console.log(category.id)
            return newArr;
        case '3':
            newArr[2].input++;
            console.log(category.id)
            return newArr;
        default:
            throw new Error();
    }
}

const PersonnelModal = () => {
    const guestData = [
        {
            id: 1,
            title: '성인',
            detail: '만 13세 이상',
            input: 0
        },
        {
            id: 2,
            title: '어린이',
            detail: '만 2~12세',
            input: 0
        },
        {
            id: 3,
            title: '유아',
            detail: '만 2세 미만',
            input: 0
        },
    ]
    const checkCnt = (id) => {
        setPlus(
            plus.map(e => {
                if((e.id === id || ((e.id===1) && (e.input === 0))) && e.input<=7) 
                return {
                    ...e,
                    input: e.input +1,
                };
                return e;
            })
        )
    }
    const [state, SetState] = useState(0);
    const [plus, setPlus] = useState(guestData);
    // const [guestInfo, dispatch] = useReducer(personnelReducer, guestData);
    console.log(plus)
    const modalList = plus.map((e, idx) => {
        return <ModalContainer onClick={e => e.stopPropagation()}>
                <Title>{e.title}</Title>
                <Detail>{e.detail}</Detail>
                <CntInfo key={idx}>
                <Input><MinusBtn key={idx} disabled><FaMinus/></MinusBtn></Input>
                <Input>{e.input}</Input>
                <Input><PlusBtn key={idx} onClick={() => checkCnt(e.id)}><FaPlus/></PlusBtn></Input>
                </CntInfo>
        </ModalContainer>
    })
    return (
        <PersonnelModalWrapper onClick={e => e.stopPropagation()}>
            {modalList}
        </PersonnelModalWrapper>
    );
}
const CntInfo = styled.ul`
position: absolute;
left: 50%;
top: 15%;
display: flex;
align-items: center;
`;
const PersonnelBtn = styled.button`
padding: 15px;
border-radius: 50%;
`
const PlusBtn = styled(PersonnelBtn)`
`;
const MinusBtn = styled(PersonnelBtn)`
`;
const Input = styled.li`
font-size: 30px;
margin:10px;
left: 75%;
top: 30%;
`;
const Title = styled.div`
font-size:25px;
`;
const Detail = styled.div`
font-size: 20px;
color: gray;
`;
const ModalContainer = styled.div`
padding: 20px;
border-bottom: 1px solid gray;
position: relative;
`;
const PersonnelModalWrapper = styled.div`
    position: absolute;
    width: 50%;
    border-radius: 50px;
    background-color: white;
    top:120%;
    left:45%;
    padding: 20px;
    & > *:last-child {
    border:none;
}
`;

export default PersonnelModal;