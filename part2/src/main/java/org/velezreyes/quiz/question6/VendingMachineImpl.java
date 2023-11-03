package org.velezreyes.quiz.question6;

public class VendingMachineImpl implements VendingMachine {

  private static VendingMachine instance;
  private Double money;

  public void setMoney(Double money) {
    this.money = money;
  }

  public VendingMachineImpl() {
    this.money = 0.0;
  }

  public static VendingMachine getInstance() {
    if (instance == null) {
      instance = new VendingMachineImpl();
    }
    return instance;
  }

  @Override
  public void insertQuarter(){
    setMoney(this.money + 0.25);
  }

  @Override
  public DrinkImpl pressButton(String name) throws NotEnoughMoneyException, UnknownDrinkException{
    if ("ScottCola".equals(name)) {
      if (this.money>=0.75) {
        setMoney(this.money - 0.75);
        return new DrinkImpl("ScottCola");
      } else {
        throw new NotEnoughMoneyException();
      }
    } else if ("KarenTea".equals(name)) {
      if (this.money==1) {
        setMoney(this.money-1);
        return new DrinkImpl("KarenTea");
      } else {
        throw new NotEnoughMoneyException();
      }
    } else {
      throw new UnknownDrinkException();
    }
  }

}
