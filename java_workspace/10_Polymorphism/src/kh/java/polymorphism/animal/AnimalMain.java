package kh.java.polymorphism.animal;


public class AnimalMain {

	public static void main(String[] args) {
		AnimalMain am = new AnimalMain();
//	    am.test1();
//		am.test2();
//		am.test3();
	
		//다형성의 활용
				//1.매개변수 선언부
//				am.test4();
				
				//2.리턴값 처리
//				am.test5();
				
				//동적바인딩
//				am.test6();
		
		      //추상메소드
//		       am.test7();
		
		     //인터페이스
		       am.test8();
				
			}
	/**
	 * 인터페이스는 객체화 할 수 없다.
	 * 인터페이스 역시 부모 타입으로 다형성을 적용할 수 있다.
	 */
	public void test8() {
//		Runnable r = new Runnable(); // 이렇게 불가능 오류남, 아래처럼 해야함 자식클래스로
		
		Runnable r1 = new Dog();
		Runnable r2 = new Cat();
		
		r1.run();
		r2.run();
		
//		r1.say();   // Animal 의 재작성메소드 say  그래서 전부오류남
//		r1.attack(); // Animal 의 재작성메소드 attack ,오류
//		r1.kick();  //Dog 의 kick ,오류  아래처럼 형병환 해야 가능 !!!
		
		((Dog)r1).say();    // 다운 캐스팅 한것  Runnable이 부모객체니까
		((Dog)r1).attack();  // 다운 캐스팅 한것  Runnable이 부모객체니까
		((Dog)r1).kick();  // 다운 캐스팅 한것  Runnable이 부모객체니까
		
		//상수
		System.out.println(Runnable.LEGS);
		
		Bitable b1 = new Dog();
		Bitable b2 = new Cat();
		b1.bite("멍멍~");
		b2.bite("왜애애애앵~");
		
		System.out.println("--------------------------------");
		
		Dog d1 = (Dog)b1; //형변환 , 다운캐스팅 (수동)
		d1.bite("멍멍~");
		d1.kick();
		d1.attack();
		d1.say();
		
		
		System.out.println("--------------------------------");
		
		Animal a1 = d1; // 업캐스팅, 자동으로됨
		a1.attack();
		a1.say();
		
		System.out.println("--------------------------------");
		
		Eagle eg1 = new Eagle();
		Flyable eg2 = new Eagle();
		Animal eg3 = new Eagle();
		
		eg1.attack();
		eg1.fly("푸더덕푸더덕");
		eg1.say();
		
		eg2.fly("파다닥");
		
		eg3.attack();
	
		
		
		
	}		
	/**
	 * 추상클래스 Animal
	 */
	public void test7() {
//		Animal a = new Animal();// Cannot instantiate the type Animal
		Animal a = new Cat();
		Animal b = new Dog();

		//추상클래스 Animal을 상속한 자식클래스는 
		//무조건 추상메소드 attack구현을 보장받는다.
		a.attack();
		b.attack();
		
			
	}			/**
			 * 동적바인딩
			 * 1. 상속 & 부모클래스의 메소드 오버라이딩 say
			 * 2. 자식객체를 부모타입으로써 제어, 해당 메소드 호출
			 * 자동으로 자식타입의 재작성한 메소드가 호출된다.
			 * 다운캐스팅 없이 자식메소드 사용 가능
			 * 
			 * 정적바인딩
			 * 동일한 타입의 메소드를 호출한다.
			 * 
			 */
			public void test6() {
				Animal a1 = new Cat();
				Animal a2 = new Dog();
				
				a1.say();
				a2.say();
				
				//다형성을 이용한 attack
				Animal[] arr = new Animal[100];
				for(int i = 0; i < arr.length; i++) {
					if(i % 2 == 0)
						arr[i] = makeDog();
					else 
						arr[i] = makeCat();
				}
				
				//실행
				for(Animal anm : arr)
					anm.attack();//동적바인딩 자식클래스의 오버라이드한 메소드가 호출됨.
			}
			
	
	



	     /**
	      * 리턴값을 다형성 이용해서 처리하기
	      * 
	      */
	     public void test5() {
	    	 Animal cat = makeCat();
	    	 Animal dog = makeDog();
	    	 
	    	 Animal[] arr = new Animal[100];
	    	 for(int i = 0; i < arr.length; i++) {
	    		 if(i % 2 == 0)
	    			 arr[i] = makeDog();
	    		 else
	    			 arr[1] = makeCat();
	    	 }
	    	 
	    	 for(Animal anm : arr)  // 이거 이해안감 무슨 뜻인지 이렇게하면 
	    		 attack(anm);
	     }
	     
	     public Dog makeDog() {
	    	 return new Dog();
	     }
	     
	     public Cat makeCat() {
	    	 return new Cat();
	     }
	 
	 
	
	//매개변수 선언부에서 다형성 활용하기
	public void test4() {
		Cat cat = new Cat();
		Dog dog = new Dog();
		
		attack(cat);
		attack(dog);
		
	}
	public void attack(Animal animal) {
		if(animal instanceof Cat) {
			((Cat) animal).punch();
		}
		else if(animal instanceof Dog) {
			((Dog) animal).kick();
		}
	}
	
	// 오버로딩 한것
//	public void attack(Cat cat) {
//		cat.punch();
//	}
//	public void attack(Dog dog) {
//		dog.kick();
//	}
	/**
	 *  Animal a = new Dog();  -> 애니멀 타입의 공간에 도그 객체를 담은것
	 *  부모 타입의 배열에 자식객체를 담을 수 있다.
	 * 
	 */
	public void test3() {
		Animal[] arr = new Animal[3];  //  여기선 참조변수의 묶음이 arr  
		arr[0] = new Cat(); // 자식
		arr[1] = new Dog(); // 자식
//		arr[2] = new Animal(); //부모
		arr[2] = new Cat();
		
		for(Animal anml : arr) {  // foreach 문 사용
			anml.say();
			
			//instanceof  - 해당타입의 객체인 경우 true  리턴
			//true 가 리턴된 경우, 해당타입으로의 안전한 형변환 보장
			//Cat 객체인 경우
			if(anml instanceof Cat) {
				((Cat)anml).punch();
				
			}
			//Dog 객체인 경우
			else if(anml instanceof Dog) {
				((Dog)anml).kick();
			}
			
		}
		
	}
	/**
	 * 형변환
	 * 두종류가 있음
	 * -upcasting - 부모타입으로 형변환 하는것, 자동(암묵적)형변환됨
	 * -downcasting - 자식타입으로 형변환 하는것, 수동(명시적)형변환
	 */
	public void test2() {
		Animal animal = new Dog(); // 업캐스팅한것, 자동으로 부모타입으로 형변환
		Dog dog = (Dog)animal; // 다운캐스팅 , 수동 형변환 한것
		
		dog.kick();
		
	}
	/**
	 * 다형성 이란?
	 * 자식객체를 부모타입의 참조변수에 담아 제어할 수 있다.
	 * 단, 자식클래스에 선언된 자원은 사용불가
	 * 
	 */
	public void test1() {
		Cat cat = new Cat();
		cat.say();
		cat.punch();
		
		Animal animal1 = cat;
		System.out.println(cat == animal1); // 주소값 비교 동등비교 연산자로
	    animal1.say();
//	    animal1.punch(); // 오류남, 이유는 부모타입 변수에 담으면
	    // 자식클래스의 선언된 자원(필드,메소드)를 사용할 수 없다.
		
		Object obj1 = cat;
//		obj1.say(); 불가
//		obj1.punch(); 불가
		System.out.println(obj1.hashCode());  // 해쉬코드나 toString 같은건 가능
		
		// 다시 자식타입의 변수에 담으면 자식타입의 자원 사용 가능
//		Animal animal2 = (Animal)obj1; // 형변환 한것
//		animal2.say();
		((Animal)obj1).say();  // 위에 두줄을 이렇게 한줄로 바꿀수있음!!!
		
//		Cat cat2 = (Cat)animal2;
//		cat2.punch();
		((Cat)obj1).punch();  // obj1 이 cat 객체인걸 아니까 형변환 한것, Dog로 바꾸면 오류남
		
		
		
	}

}
