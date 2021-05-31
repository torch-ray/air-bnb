import React, {useState} from 'react';
import styled from 'styled-components';
import {Slider} from "@material-ui/core";

const PriceModal = () => {
    const gfg = [
        {
          value: 0,
          label: "0",
        },
        {
          value: 100,
          label: "100",
        },
      ];
      const [val, setVal] = useState([0, 100]);
      const updateRange = (e, data) => {
        setVal(data);
      };
    return (
        <PriceModalWrapper className="PriceModal" onClick={e => e.stopPropagation()}>
            <PriceContainer>
                <span> min/max : </span>
                {val.map(e => <div>{e}</div>)}
                <Slider value={val} onChange={updateRange} marks={gfg} />
            </PriceContainer>{" "}
        </PriceModalWrapper>
    );
}

const PriceModalWrapper = styled.div`
    position: absolute;
    width: 70%;
    height: 300px;
    border-radius: 50px;
    background-color: #cfcfac;
    top:120%;
    left:20%;
    color: green;
  font-size: 16px;
`;

const PriceContainer = styled.div`
/* text-align: center; */
padding: 30px;
width: 70%;
`;
export default PriceModal;
