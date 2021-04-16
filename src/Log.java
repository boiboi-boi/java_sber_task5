public class Log {
    private String ip;
    private String user;
    private String date;
    private String event;
    private String status;

    String getIp (){ return ip;}
    String getUser (){ return user;}
    String getDate (){ return date; }
    String getEvent (){ return event;}
    String getStatus () {return status;}

    void setIp(String value){ this.ip = value;}
    void setUser(String value){ this.user = value;}
    void setDate(String value){ this.date = value;}
    void setEvent(String value) { this.event = value;}
    void setStatus(String value) {this.status = value;}



}