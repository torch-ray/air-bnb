import Foundation
import RxSwift
import RxCocoa

enum GuestType: CaseIterable {
    case adult
    case kid
    case infant
}

final class GuestManager {
    
    private var adults: AdultState
    private var kid : KidState
    private var infant: InfantState
    private let disposeBag = DisposeBag()
    private var guestState: [GuestType: StateProtocol]
    private lazy var guests: [StateProtocol] = [adults, kid, infant]
    
    init() {
        adults = AdultState()
        kid = KidState()
        infant = InfantState()
        guestState = [:]
        guestState = Dictionary(uniqueKeysWithValues: zip(GuestType.allCases, guests))
    }
    
    func increase(_ guest:GuestType) {
        guestState[guest]?.increase()
    }
    
    func decrease(_ guest:GuestType) {
        guestState[guest]?.decrease()
    }
    
    lazy var adultCount:Driver<String> = {
        return adults.countStates()
            .map{String($0)}
            .asDriver(onErrorJustReturn: "")
    }()
    
    lazy var kidCount:Driver<String> = {
        return kid.countStates()
            .map{String($0)}
            .asDriver(onErrorJustReturn: "")
    }()
    
    lazy var infantCount:Driver<String> = {
        return infant.countStates()
            .map{String($0)}
            .asDriver(onErrorJustReturn: "")
    }()
}
