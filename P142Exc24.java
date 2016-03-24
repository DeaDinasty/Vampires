import java.lang.Math.*;

class Exc24{
	static void Vampires(int kol_num){
		int vamNum = 0;
		if(kol_num < 2 && kol_num%2 != 0) {
			System.out.println("Вампир должен состоять из четного количества цифр\n\tне меньше 2!!! "); 
			return;
		}
		for(int i = (int) Math.pow(10L, kol_num-1); i < (int) Math.pow(10, kol_num); i++) {
			for(int z1 = (int) Math.pow(10L, kol_num/2-1); z1 < (int) Math.pow(10, kol_num/2); z1++) {
				M1: for(int z2 = z1; z2 < (int) Math.pow(10, kol_num/2); z2++) {
					if(z1*z2<i) continue;
					if(z1*z2>i) break;
					if(z1%10 == 0 && z2%10 == 0) continue;
					String strnum = String.valueOf(i);	
					for(int pr = 0; pr < kol_num/2; pr++){
						if(strnum.contains(String.valueOf(String.valueOf(z1).charAt(pr)))) {
							strnum = strnum.replaceFirst(String.valueOf(String.valueOf(z1).charAt(pr)), "");
						} else continue M1;
					}
					
					for(int pr = 0; pr < kol_num/2; pr++){
                                        	if(strnum.contains(String.valueOf(String.valueOf(z2).charAt(pr)))) {
                                        		strnum = strnum.replaceFirst(String.valueOf(String.valueOf(z2).charAt(pr)), "");
						} else continue M1; 	
					}
					if(strnum.isEmpty()) {
						System.out.println(i + " = " + z1 + " * " + z2); 
						vamNum++;
					}
				}
			}
		}
		System.out.println("Найдено вампиров: " + vamNum);
		System.out.println("Проверено " + ((int) Math.pow(10, kol_num) - (int) Math.pow(10L, kol_num-1) + 1) + " чисел.");  
	}

	public static void main(String args[]) {
		try{
			Vampires(Integer.valueOf(args[0]));
		} catch(Exception e) {
			System.out.println("Надо ввести число цифр в вампире!!!"); 
		}
	} 
}
