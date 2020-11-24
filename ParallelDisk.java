package com.test.method;
import java.util.Scanner;
import java.lang.Math;
import com.module.method.CSCAN;
import com.module.method.FCFS;
import com.module.method.SCAN;
import com.module.method.SSTF;
public class ParallelDisk {
	public static void main(String[] args) {
		int PC,wholetrack;
		Scanner scan4 = new Scanner(System.in);
		System.out.println("磁盘一共多少磁道?");
		wholetrack = scan4.nextInt();
		System.out.println("磁头的初始位置是?");
		PC = scan4.nextInt();
		System.out.println("需要多少个使用FCFS方法的进程？");
		int FCFScount = scan4.nextInt();
		System.out.println("需要多少个使用SSTF方法的进程？");
		int SSTFcount = scan4.nextInt();
		System.out.println("需要多少个使用SCAN方法的进程？");
		int SCANcount = scan4.nextInt();
		System.out.println("需要多少个使用CSCAN方法的进程？");
		int CSCANcount = scan4.nextInt();
		FCFS fcfsset[] = new FCFS[FCFScount];
		int fcfstrack;
		for(int fs=0;fs<FCFScount;fs++){
			fcfsset[fs]=new FCFS();
			System.out.println("当前FCFS方法需要占用多少磁道？");
			fcfstrack = scan4.nextInt();
			fcfsset[fs].setBase(wholetrack, fcfstrack, PC);
			fcfsset[fs].initialData();
		}
		SSTF sstfset[] = new SSTF[SSTFcount];
		int sstftrack;
		for(int sf=0;sf<SSTFcount;sf++){
			sstfset[sf]=new SSTF();
			System.out.println("当前SSTF方法需要占用多少磁道？");
			sstftrack = scan4.nextInt();
			sstfset[sf].setBase(wholetrack, sstftrack, PC);
			sstfset[sf].initialData();
		}
		SCAN scanset[] = new SCAN[SCANcount];
		int scantrack;
		for(int sn=0;sn<SCANcount;sn++){
			scanset[sn]=new SCAN();
			System.out.println("当前SCAN方法需要占用多少磁道？");
			scantrack = scan4.nextInt();
			scanset[sn].setBase(wholetrack, scantrack, PC);
			scanset[sn].initialData();
		}
		CSCAN cscanset[] = new CSCAN[CSCANcount];
		int cscantrack;
		for(int cn=0;cn<CSCANcount;cn++){
			cscanset[cn]=new CSCAN();
			System.out.println("当前CSCAN方法需要占用多少磁道？");
			cscantrack = scan4.nextInt();
			cscanset[cn].setBase(wholetrack, cscantrack, PC);
			cscanset[cn].initialData();
		}
		int fcfsnow=0,sstfnow=0,scannow=0,cscannow=0;
		int countnum=FCFScount+SSTFcount+SCANcount+CSCANcount;
		for(int i=0;i<countnum;i++){	
			int randomSignal=1 + (int)(Math.random()*4);
			switch (randomSignal){
				case 1:
					if(fcfsnow<FCFScount){
					fcfsset[fcfsnow].setPCPosition(PC);
					fcfsset[fcfsnow].run();
					PC = fcfsset[fcfsnow].getPCPosition();
					System.out.println("使用简单评估(平均数法)得到的平均寻道长度:"+fcfsset[fcfsnow].easyStimulate());
					System.out.println("使用线性回归得到的拟合寻道复杂度函数:");
					fcfsset[fcfsnow].linearStimulate();
					fcfsnow++;
					}
					else{
						i--;
					}
					break;
				case 2:
					if(sstfnow<SSTFcount){
					sstfset[sstfnow].setPCPosition(PC);
					sstfset[sstfnow].run();
					PC = sstfset[sstfnow].getPCPosition();
					System.out.println("使用简单评估(平均数法)得到的平均寻道长度:"+sstfset[sstfnow].easyStimulate());
					System.out.println("使用线性回归得到的拟合寻道复杂度函数:");
					sstfset[sstfnow].linearStimulate();
					sstfnow++;
					}
					else{
						i--;
					}
					break;
				case 3:
					if(scannow<SCANcount){
					scanset[scannow].setPCPosition(PC);
					scanset[scannow].run();
					PC = scanset[scannow].getPCPosition();
					System.out.println("使用简单评估(平均数法)得到的平均寻道长度:"+scanset[scannow].easyStimulate());
					System.out.println("使用线性回归得到的拟合寻道复杂度函数:");
					scanset[scannow].linearStimulate();
					scannow++;
					}
					else{
						i--;
					}
					break;
				case 4:
					if(cscannow<CSCANcount){
					cscanset[cscannow].setPCPosition(PC);
					cscanset[cscannow].run();
					PC = cscanset[cscannow].getPCPosition();
					System.out.println("使用简单评估(平均数法)得到的平均寻道长度:"+cscanset[cscannow].easyStimulate());
					System.out.println("使用线性回归得到的拟合寻道复杂度函数:");
					cscanset[cscannow].linearStimulate();
					cscannow++;
					}
					else{
						i--;
					}
					break;
				default:
					i--;
					break;
			}
		}
	}
}
