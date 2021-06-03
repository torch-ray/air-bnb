import UIKit
import RxSwift
import RxCocoa

final class GuestViewController: UIViewController {
    
    @IBOutlet weak var infantCountLabel: UILabel!
    @IBOutlet weak var kidCountLabel: UILabel!
    @IBOutlet weak var adultCountLabel: UILabel!
    @IBOutlet weak var guestLabel: UILabel!
    @IBOutlet weak var priceLabel: UILabel!
    @IBOutlet weak var dateLabel: UILabel!
    @IBOutlet weak var locationLabel: UILabel!
    @IBOutlet weak var backButton: UIButton!
    @IBOutlet var buttonController: ButtonController!
    private let viewModel = GuestViewModel()
    private let guestManager = GuestManager()

    override func viewDidLoad() {
        super.viewDidLoad()
        setupMainView()
        bind()
    }
    
    func setupInfo(_ location:String, _ date:String, _ price:String) {
        viewModel.setupInfo(location, date, price)
    }
}

private extension GuestViewController {
    
    private func setupMainView() {
        setupBackButton()
        setupButtonController()
    }
    
    private func setupBackButton() {
        backButton.rx.tap
            .subscribe(onNext: { [weak self] _ in
                self?.dismiss(animated: true, completion: nil)
            }).disposed(by: rx.disposeBag)
    }
    
    private func setupButtonController() {
        buttonController.setupButton()
        buttonController.bind { [weak self] (type, action) in
            switch action {
            case.increase: self?.guestManager.increase(type)
            case.decrease: self?.guestManager.decrease(type)
            }
        }
    }
}

private extension GuestViewController {
    
    private func bind() {
        bindLocationLabel()
        bindDateLabel()
        bindPriceLabel()
        bindCountStateLabel()
    }
    
    private func bindLocationLabel() {
        viewModel.locationData
            .drive(locationLabel.rx.text)
            .disposed(by: rx.disposeBag)
    }
    
    private func bindDateLabel() {
        viewModel.dateData
            .drive(dateLabel.rx.text)
            .disposed(by: rx.disposeBag)
    }
    
    private func bindPriceLabel() {
        viewModel.priceData
            .drive(priceLabel.rx.text)
            .disposed(by: rx.disposeBag)
    }
    
    private func bindCountStateLabel() {
        guestManager.adultCount
            .drive(adultCountLabel.rx.text)
            .disposed(by: rx.disposeBag)
        
        guestManager.kidCount
            .drive(kidCountLabel.rx.text)
            .disposed(by: rx.disposeBag)
        
        guestManager.infantCount
            .drive(infantCountLabel.rx.text)
            .disposed(by: rx.disposeBag)
    }
}
