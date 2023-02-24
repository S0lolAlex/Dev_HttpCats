public class HttpStatusChecker {
    ConnectUtil answer = new ConnectUtil();
    public String getStatusImage(int code) throws Exception {
        String result = null;
        if(answer.getConnect(code) == 200){
            result = String.format("https://http.cat/%s.jpg",code);
        }else{
            throw new Exception(String.format("There is not image for HTTP status <%s>",code));
        }
        return result;
    }
}
