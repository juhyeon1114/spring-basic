package hello.springbasic.lifecycle;

//public class NetworkClient implements InitializingBean, DisposableBean {
public class NetworkClient {

    private String url;

    public NetworkClient() {
//        connect();
//        call("초기화 연결 메세지");
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void connect() {
        System.out.println("Connect = " + url);
    }

    public void call(String message) {
        System.out.println("Call: " + url + " message : " + message);
    }

    public void disconnect() {
        System.out.println("Disconnect = " + url);
    }

//    // 의존 관계 주입 후 호출됨
//    @Override
//    public void afterPropertiesSet() throws Exception {
//        connect();
//        call("초기화 연결 메세지");
//    }
//
//    // 빈이 종룔될 때 호출
//    @Override
//    public void destroy() throws Exception {
//        disconnect();
//    }


    public void init() {
        connect();
        call("초기화 연결 메세지");
    }

    public void close() {
        disconnect();
    }
}

