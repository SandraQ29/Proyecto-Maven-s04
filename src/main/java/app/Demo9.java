package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import modelo.Usuario;

public class Demo9 {
	
	public static void main(String[] args) {
		
		
		//especificar la conexion de BD -DAOFACTORY
		EntityManagerFactory fabrica=Persistence.createEntityManagerFactory("mysql");
		
		//2.Obtener el DAO
		EntityManager em=fabrica.createEntityManager();
		//procesos...obtener la info del usuario con codigo 12
		String sql = "{call usp_validaAcceso(?,?)}";
		Query query3=em.createNativeQuery(sql,Usuario.class);
		query3.setParameter("xusuario", "U002@gmail.com");
		query3.setParameter("xcla", "10003");
		Usuario u=null;
		try {
			u =(Usuario) query3.getSingleResult();
		} catch (NoResultException e) {
			// TODO Auto-generated catch block
			
		}
		if(u==null) {
			System.out.println("Usuario NO EXISTE");
		}else {
			System.out.println("Usuario encontrdo: " +u.getNombre());
			System.out.println(u);
		}
		
		em.close();
		
		
		
		
	}

}
