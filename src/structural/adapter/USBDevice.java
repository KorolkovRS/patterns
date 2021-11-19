package structural.adapter;

interface USB {
    void connectWithUSB();
    void getDataFromUSBPort();
    void sendDataToUSBPort();
}

class USBDevice implements USB {
    @Override
    public void connectWithUSB() {
        System.out.println("USB device connection");
    }
    @Override
    public void getDataFromUSBPort() {
        System.out.println("Get data from USB port");
    }
    @Override
    public void sendDataToUSBPort() {
        System.out.println("Send data to USB port");
    }
}

interface RS485 {
    void connectWithRS485();
    void getDataFromRS485Port();
    void sendDataToRS485Port();
}

class RS485Device implements RS485 {
    @Override
    public void connectWithRS485() {
        System.out.println("RS485 device connection");
    }
    @Override
    public void getDataFromRS485Port() {
        System.out.println("Get data from RS485 port");
    }
    @Override
    public void sendDataToRS485Port() {
        System.out.println("Send data to RS485 port");
    }
}

class USBtoRS485Adapter implements USB {
    private RS485Device rs485Device;

    public USBtoRS485Adapter(RS485Device rs485Device) {
        this.rs485Device = rs485Device;
    }


    @Override
    public void connectWithUSB() {
        rs485Device.connectWithRS485();
    }

    @Override
    public void getDataFromUSBPort() {
        rs485Device.getDataFromRS485Port();
    }

    @Override
    public void sendDataToUSBPort() {
        rs485Device.sendDataToRS485Port();
    }
}



class Solution {
    public static void main(String[] args) {
        USB usb = new USBtoRS485Adapter(new RS485Device());
        usb.connectWithUSB();
        usb.sendDataToUSBPort();
        usb.getDataFromUSBPort();
    }
}