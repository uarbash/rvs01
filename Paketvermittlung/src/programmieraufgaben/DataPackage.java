package programmieraufgaben;


import java.util.List;

 
public class DataPackage {
    
    private int dataPackageLength;
    private int version;
    private String Sender;
    private String reciver;
    private int packetNumber;
    private int dataSize;
    private char [] Data;
    
    
    public DataPackage(int dataPackageLength) {
        this.dataPackageLength = dataPackageLength;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public void setSender(String Sender) {
        this.Sender = Sender;
    }

    public void setReciver(String reciver) {
        this.reciver = reciver;
    }

    public void setPacketNumber(int packetNumber) {
        this.packetNumber = packetNumber;
    }

    public void setDataSize(int dataSize) {
        this.dataSize = dataSize;
    }

    public void setData(char [] Data) {
        this.Data = Data;
    }
   

    public int getVersion() {
        return version;
    }

    public String getSender() {
        return Sender;
    }

    public String getReciver() {
        return reciver;
    }

    public int getPacketNumber() {
        return packetNumber;
    }

    public char [] getData() {
        return Data;
    }

    
    
    public int getDataPackageLength() {
        return dataPackageLength;
    }

  
    public void setDataPackageLength(int dataPackageLength) {
        this.dataPackageLength = dataPackageLength;
    }

    @Override
    public String toString() {
        
       return "DataPackage{" + "version=" + version + ", Sender=" + Sender + ", reciver=" + reciver + ", packetNumber=" + packetNumber + ", dataSize=" + dataSize + ", Data=" + Data.toString() + '}';
    }
    
    
}
