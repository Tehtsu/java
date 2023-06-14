public class Test {
    public static void main(String[] args){
        int i = 1;
        int j = i;
        for (;i<3;i++){
            j+=i;
        }
        System.out.println(j);
    }
}
