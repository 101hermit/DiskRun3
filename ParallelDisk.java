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
		System.out.println("����һ�����ٴŵ�?");
		wholetrack = scan4.nextInt();
		System.out.println("��ͷ�ĳ�ʼλ����?");
		PC = scan4.nextInt();
		System.out.println("��Ҫ���ٸ�ʹ��FCFS�����Ľ��̣�");
		int FCFScount = scan4.nextInt();
		System.out.println("��Ҫ���ٸ�ʹ��SSTF�����Ľ��̣�");
		int SSTFcount = scan4.nextInt();
		System.out.println("��Ҫ���ٸ�ʹ��SCAN�����Ľ��̣�");
		int SCANcount = scan4.nextInt();
		System.out.println("��Ҫ���ٸ�ʹ��CSCAN�����Ľ��̣�");
		int CSCANcount = scan4.nextInt();
		FCFS fcfsset[] = new FCFS[FCFScount];
		int fcfstrack;
		for(int fs=0;fs<FCFScount;fs++){
			fcfsset[fs]=new FCFS();
			System.out.println("��ǰFCFS������Ҫռ�ö��ٴŵ���");
			fcfstrack = scan4.nextInt();
			fcfsset[fs].setBase(wholetrack, fcfstrack, PC);
			fcfsset[fs].initialData();
		}
		SSTF sstfset[] = new SSTF[SSTFcount];
		int sstftrack;
		for(int sf=0;sf<SSTFcount;sf++){
			sstfset[sf]=new SSTF();
			System.out.println("��ǰSSTF������Ҫռ�ö��ٴŵ���");
			sstftrack = scan4.nextInt();
			sstfset[sf].setBase(wholetrack, sstftrack, PC);
			sstfset[sf].initialData();
		}
		SCAN scanset[] = new SCAN[SCANcount];
		int scantrack;
		for(int sn=0;sn<SCANcount;sn++){
			scanset[sn]=new SCAN();
			System.out.println("��ǰSCAN������Ҫռ�ö��ٴŵ���");
			scantrack = scan4.nextInt();
			scanset[sn].setBase(wholetrack, scantrack, PC);
			scanset[sn].initialData();
		}
		CSCAN cscanset[] = new CSCAN[CSCANcount];
		int cscantrack;
		for(int cn=0;cn<CSCANcount;cn++){
			cscanset[cn]=new CSCAN();
			System.out.println("��ǰCSCAN������Ҫռ�ö��ٴŵ���");
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
					System.out.println("ʹ�ü�����(ƽ������)�õ���ƽ��Ѱ������:"+fcfsset[fcfsnow].easyStimulate());
					System.out.println("ʹ�����Իع�õ������Ѱ�����ӶȺ���:");
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
					System.out.println("ʹ�ü�����(ƽ������)�õ���ƽ��Ѱ������:"+sstfset[sstfnow].easyStimulate());
					System.out.println("ʹ�����Իع�õ������Ѱ�����ӶȺ���:");
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
					System.out.println("ʹ�ü�����(ƽ������)�õ���ƽ��Ѱ������:"+scanset[scannow].easyStimulate());
					System.out.println("ʹ�����Իع�õ������Ѱ�����ӶȺ���:");
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
					System.out.println("ʹ�ü�����(ƽ������)�õ���ƽ��Ѱ������:"+cscanset[cscannow].easyStimulate());
					System.out.println("ʹ�����Իع�õ������Ѱ�����ӶȺ���:");
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
