import java.util.Random;

//total: the original total number of the product
//original_rate: the original rate
//rate: the real-time rate
//sum: the sum of shares that people want to buy but not succeed
//remain: the remain shares of the product
//paid: the sum of shares that have been bought
//a: the coefficient = sum/remain
//willing: people's willing to buy
//returnValue: the total number of money that should be paid to all the people

public class Run {
	public double total,original_rate, rate, sum,remain, paid,a,willing,returnValue=0;
	public int time;
	static Random rand= new Random();

	public Run(double total, double rate) {
		this.total=total;
		this.remain=total;
		this.original_rate=this.rate=rate;	
		this.time=0;
		this.willing=1;
	}
	
	public void buyer(){
		demonds(willing);
		a=sum/remain;
		if (a>1.5)
			new_rate(a);
//		System.out.println(rate);
//		System.out.println(remain);
//		System.out.println(sum);
	}
	
	public void demonds(double willing) {
		sum=0;
		int numOfPeo=rand.nextInt((int)(200*willing));  //assume at the beginning, the maximum number of people is 200.
		int[] money= new int[numOfPeo];
		int[] operationTime= new int[numOfPeo];
		int threshold= rand.nextInt(5);
		for (int i = 0; i < operationTime.length; i++) {
			money[i]=(rand.nextInt(100))*100;
			operationTime[i]=(int) Math.abs( (Math.sqrt(5)*rand.nextGaussian()+5));
			if (operationTime[i]< threshold){
				if (remain>money[i]){
				paid+=money[i];
				remain-=money[i];
				returnValue+=money[i]*(1+rate);}
				else{
					returnValue+=remain*(1+rate);
					remain=0;
				}
			}
			else sum+=money[i];	   // the sum  that people want to buy but not succeed		
		}
	}
	
	public void new_rate(double a) {
		if (this.rate>0.8*original_rate){
			this.rate=this.rate*(1-0.2*sigmoid((a-4)/2));
			this.willing=this.rate/original_rate;   //when the rate declines, people's willing will also decline
		}
	}
	
	public double sigmoid(double x) {
		return 1/(1+ Math.exp(-x));
	}

}
