import java.util.Random;

public class Run {
	public double total,original_rate, rate, sum, paid,a,willing;
	public int time;
	static Random rand= new Random();

	public Run(double total, double rate) {
		this.total=total;
		this.original_rate=this.rate=rate;	
		this.time=0;
		this.willing=1;
	}
	
	public void buyer(){
		sum=100;
		total=10;
		a=sum/total;
		if (a>2)
			new_rate(a);
		System.out.println(rate);
	}
	
	public double demonds(double willing) {
		int numOfPeo=rand.nextInt((int)(100*willing));
		int[] money= new int[numOfPeo];
		int[] operationTime= new int[numOfPeo];
		for (int i = 0; i < operationTime.length; i++) {
			money[i]=(rand.nextInt(100))*100;
			operationTime[i]=(int) Math.abs( (Math.sqrt(5)*rand.nextGaussian()+5));
		}
	}
	
	public void new_rate(double a) {
		if (this.rate>0.8*original_rate){
			this.rate=this.rate*(1-0.2*sigmoid((a-6)/2));
			this.willing=this.rate/original_rate;
		}
	}
	
	public double sigmoid(double x) {
		return 1/(1+ Math.exp(-x));
	}

}
