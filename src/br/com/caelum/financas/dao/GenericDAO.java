package br.com.caelum.financas.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;


import br.com.caelum.financas.modelo.Conta;
import net.jodah.typetools.TypeResolver;

public class GenericDAO<Type>{
	
	private EntityManager manager;
	private Class objectClass;;

	public GenericDAO(EntityManager manager, Class entityClass)
	{
		this.manager = manager;
		//Class<?>[] typeArguments = TypeResolver.resolveRawArguments(GenericDAO.class, getClass());
	    //this.objectClass =  typeArguments[0];
		this.objectClass = entityClass;
	}
	
	public void adiciona(Type persistentObject)
	{

		manager.persist(persistentObject);
	}
	
	public void altera(Type persistentObject)
	{
		persistentObject = manager.merge(persistentObject);
	}
	
	public void deleta(Type persistentObject)
	{
		manager.remove(persistentObject);
	}
	
	public Type busca(Integer id)
	{
		return (Type) manager.find(objectClass, id);
	}
	
	public List<Type> lista()
	{
		return (List<Type>) this.manager.createQuery("select c from "+ objectClass.getName()+"  c", objectClass).getResultList();
	}
}
