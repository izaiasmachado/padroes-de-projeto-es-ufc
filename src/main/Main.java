package main;
public class Main {
	public static void main(String[] args) {
		String helloMessage = hello();

		try {
			Endereco a = new EnderecoAdapter();
			Endereco b = new EnderecoAdapter();
			
//			b.setCep("62011140");
//			System.out.println(b.toString());
//			
//			a.setCep("62011050");
//			System.out.println(a.toString());

			a.setUf("CE");
			
			System.out.println(a.toString());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String hello() {
		return "Hello Transportadora";
	}
}
