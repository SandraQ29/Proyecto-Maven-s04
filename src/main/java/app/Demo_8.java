package app;



import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import modelo.Usuario;

public class Demo_8 {
	public static void main(String[] args) {
		//especificar la conexion de BD -DAOFACTORY
		EntityManagerFactory fabrica=Persistence.createEntityManagerFactory("mysql");
		
		//2.Obtener el DAO
		EntityManager em=fabrica.createEntityManager();
		//procesos...obtener la info del usuario con codigo 12
		String sql = "Select u  from Usuario u where u.usuario= :xusuario and u.clave=:xcla";
		TypedQuery<Usuario> query3=em.createQuery(sql,Usuario.class);
		query3.setParameter("xusuario", "U001@gmail.com");
		query3.setParameter("xcla", "10001");
		Usuario u=null;
		try {
			u =query3.getSingleResult();
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
