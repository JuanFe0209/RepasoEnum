package domain.enums;

public enum ClientType {

    TEAR1(2.00){
        @Override
        public String printMessage() {
            return "Tear1";
        }
    },
    TEAR2(3.00){
        @Override
        public String printMessage() {
            return "Tear2";
        }
    },
    TEAR3(4.00){
        @Override
        public String printMessage() {
            return "Tear3";
        }
    };
    private double discount;

    ClientType(double discount) {
        this.discount = discount;
    }
    public double getDiscount() {
        return discount;
    }
    public abstract String printMessage();

}
