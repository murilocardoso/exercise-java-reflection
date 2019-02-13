package application;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

import model.Person;

public class Program {

	/**
	 * @param args
	 * @throws ClassNotFoundException
	 */
	public static void main(String[] args) throws ClassNotFoundException {
		String personClassName = "model.Person";
		Class<?> personClass = Class.forName(personClassName);
		
		System.out.println("Person class: "+ personClass);
		
		System.out.println();
		System.out.println("-----------------");
		
		Field[] fields = personClass.getFields();
		System.out.println("Fields: ");
		Arrays.stream(fields).forEach(
				field -> System.out.println(Modifier.toString(field.getModifiers()) + " " +
											field.getType().getSimpleName() + " " +
											field.getName()));
		
		System.out.println();
		System.out.println("-----------------");
		
		Field[] declaredFields = personClass.getDeclaredFields();
		System.out.println("DeclaredFields: ");
		Arrays.stream(declaredFields).forEach(
				field -> System.out.println(Modifier.toString(field.getModifiers()) + " " +
											field.getType().getSimpleName() + " " +
											field.getName()));
		
		System.out.println();
		System.out.println("-----------------");
		
		Constructor<?>[] constructors = personClass.getConstructors();
		System.out.println("Constructors: ");
		Arrays.stream(constructors).forEach(System.out::println);
		
		System.out.println();
		System.out.println("-----------------");
		
		Constructor<?>[] declaredConstructors = personClass.getDeclaredConstructors();
		System.out.println("DeclaredConstructors: ");
		Arrays.stream(declaredConstructors).forEach(System.out::println);
		
		System.out.println();
		System.out.println("-----------------");
		
		Method[] staticMethods = personClass.getMethods();
		System.out.println("StaticMethods: ");
		Arrays.stream(staticMethods).filter(x -> Modifier.isStatic(x.getModifiers()) == true).forEach(System.out::println);
		
		System.out.println();
		System.out.println("-----------------");
		
		Method[] declaredStaticMethods = personClass.getDeclaredMethods();
		System.out.println("DeclaredStaticMethods: ");
		Arrays.stream(declaredStaticMethods).filter(x -> Modifier.isStatic(x.getModifiers()) == true).forEach(System.out::println);
		
		System.out.println();
		System.out.println("-----------------");
		
		Method[] methods = personClass.getMethods();
		System.out.println("Methods: ");
		Arrays.stream(methods).filter(x -> Modifier.isStatic(x.getModifiers()) == false).forEach(System.out::println);
		
		System.out.println();
		System.out.println("-----------------");
		
		Method[] declaredMethods = personClass.getDeclaredMethods();
		System.out.println("DeclaredMethods: ");
		Arrays.stream(declaredMethods).filter(x -> Modifier.isStatic(x.getModifiers()) == false).forEach(System.out::println);
	}

}
