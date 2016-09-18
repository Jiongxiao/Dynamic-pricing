
public class TestRun {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Run test=new Run(3000000, 0.06);
		while(test.remain>0){
			test.buyer();
			System.out.println(test.rate);
			System.out.println(test.remain);
			System.out.println(test.sum);
			Thread.sleep(1000);
		}
		System.err.println(test.returnValue);
	
	}

}
