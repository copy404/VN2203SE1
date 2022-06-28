package exception;

public class TryCatchDemo {
    public static void main(String[] args) {
        System.out.println("程序开始了");
        try {
//            String str = null;
            String str = "";
            System.out.println(str.length());
            System.out.println(str.charAt(0));
            System.out.println("1");
//        }catch (NullPointerException e){
//            System.out.println("出现了空指针，并在这里得到了解决");
//        }catch (StringIndexOutOfBoundsException e){
//            System.out.println("出现了下标越界异常，并在这里得到了解决");
//        }
//        }catch (NullPointerException|StringIndexOutOfBoundsException e){
//            System.out.println("出现了空指针或标越界异常，并在这里得到了解决");
//        }
        }catch (Exception e){
            System.out.println("出现了异常，并在这里得到了解决");
        }
        System.out.println("程序结束了");

    }
}
