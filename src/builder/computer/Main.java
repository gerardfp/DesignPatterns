package builder.computer;

class Computer {

    //required parameters
    private String HDD;
    private String RAM;

    //optional parameters
    private boolean isGraphicsCardEnabled;
    private boolean isBluetoothEnabled;

    private Computer() {
    }

    public static class Builder {

        // required parameters
        private String HDD;
        private String RAM;

        // optional parameters
        private boolean isGraphicsCardEnabled;
        private boolean isBluetoothEnabled;

        public Builder(String hdd, String ram) {
            this.HDD = hdd;
            this.RAM = ram;
        }

        public Builder setGraphicsCardEnabled(boolean isGraphicsCardEnabled) {
            this.isGraphicsCardEnabled = isGraphicsCardEnabled;
            return this;
        }

        public Builder setBluetoothEnabled(boolean isBluetoothEnabled) {
            this.isBluetoothEnabled = isBluetoothEnabled;
            return this;
        }

        public Computer build() {
            Computer computer = new Computer();
            computer.HDD = this.HDD;
            computer.RAM = this.RAM;
            computer.isGraphicsCardEnabled = this.isGraphicsCardEnabled;
            computer.isBluetoothEnabled = this.isBluetoothEnabled;
            return computer;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Computer computer = new Computer.Builder("200GB", "8GB")
                .setBluetoothEnabled(true)
                .setGraphicsCardEnabled(true)
                .build();
    }
}
