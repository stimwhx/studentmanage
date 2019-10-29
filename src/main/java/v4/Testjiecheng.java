package v4;

public class Testjiecheng {
    public static void main(String[]args){
       /* long sum =0;
        long fac = 1;
        StringBuilder stringBuilder = new StringBuilder();
        for(int i =1;i<10;i++){
            fac = fac*i;
            sum = sum+fac;
            stringBuilder.append(i+"*");
        }
        stringBuilder.append("="+sum);
        System.out.println(stringBuilder);

    }*/
       Testjiecheng.quiweishu(12345678);
}
public static long jiecheng(int i ){
        long values =0;
        if(i==0||i==1){
            values=1;
        }else if(i>1){
            values= i*jiecheng(i-1);
        }
return values;

}
public static long getAge(int a){
        long age =0 ;
        if(a==1){
            age = 10;
        }else if(a>1){
            age=2+getAge(a-1);
        }
        return  age;
}
public static String quiweishu(int t){
        String str = String.valueOf(t);
        System.out.println("这是几位数"+str.length());
        int f = str.length()-1;
    char[] ch = str.toCharArray();
        for(int i =f;i>=0;i--){
            System.out.print(ch[i]);
        }


        return null;
}
public static void huishu(int i ){
        String str = String.valueOf(i);
        boolean b = false;
        if(str.length()==5){
            char[]ch=str.toCharArray();
            for(int a =0;a<ch.length;a++){
                for(int j = ch.length-1;j>=0;j--){
                    if(String.valueOf(ch[a]).equals(String.valueOf(ch[j]))){
                        b=true;
                    }else{
                        b=false;
                    }
                }
            }
        }else{
            System.out.println("您输入的不是5位数字");
        }
if(b==true){
    System.out.println("是回数");
}
}
}
