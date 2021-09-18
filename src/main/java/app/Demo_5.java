package app;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import modelo.Usuario;

public class Demo_5 {
	public static void main(String[] args) {
		//especificar la conexion de BD -DAOFACTORY
		EntityManagerFactory fabrica=Persistence.createEntityManagerFactory("mysql");
		
		//2.Obtener el DAO
		EntityManager em=fabrica.createEntityManager();
	
		TypedQuery<Usuario> query=em.createQuery("Select u  from Usuario u", Usuario.class);
		List<Usuario> lstUsuarios= query.getResultList();
		System.out.println("Cantidad de usuarios: "+ lstUsuarios.size());
		if(lstUsuarios.size()==0) {
			System.out.println("Listado vacio");
		}else {
			for(Usuario u: lstUsuarios) {
				System.out.println(">>> "+u);
			}
		}
		
		//listado de los usuarios -- select * from tb_usuario
		

		String sql = "Select u  from Usuario u where u.usuario= :xusuario";
		TypedQuery<Usuario> query3=em.createQuery(sql,Usuario.class);
		query3.setParameter("xtipo", 1);
		List<Usuario> lstUsuarios3= query3.getResultList();
		System.out.println("Cantidad de usuarios: "+ lstUsuarios3.size());
		if(lstUsuarios3.size()==0) {
			System.out.println("Listado vacio");
		}else {
			System.out.println("--Listado de usuarios tipo1 --");
			for(Usuario u: lstUsuarios3) {
				System.out.println(">>> "+u);
			}
		}
		
		
		em.close();
		
		
		
		
	}

}
