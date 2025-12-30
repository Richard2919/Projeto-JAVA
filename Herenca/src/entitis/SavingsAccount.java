package entitis;

public class SavingsAccount extends Account{
    private Double interestRate;

    public SavingsAccount(){
        super();
    }

    public SavingsAccount(Integer number, String holder, Double balance, Double interestRate) {
        super(number, holder, balance);
        this.interestRate = interestRate;
    }

    public Double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(Double interestRate) {
        this.interestRate = interestRate;
    }

    public void uppdateBalance(){
        balance += balance * interestRate;
    }

    @Override //usado para sobreposição, no caso sobre pos o metodo da classe account
    public void withdraw(double amount){
        balance -= amount;
    }
}
