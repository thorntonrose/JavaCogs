package org.javacogs;

import java.beans.*;
import java.util.*;
import java.lang.reflect.*;

/**
 * <code>ObjectProxy</code> is used to access objects dynamically at runtime.
 * It provides methods for getting properties, setting properties, and invoking
 * methods on a target object. It is useful in situations where object 
 * properties and methods are not known at compile time, or where compile 
 * time access would result in brittle code.
 *
 * <p>Here is an example of brittle code:
 * <pre>
 * public class LogTableModel extends AbstractTableModel {
 *    ...
 *
 *    public Object getValueAt(int row, int col) {
 *       LogEntry entry;
 *       Object   value;
 *
 *       try {
 *          entry = log.get(row);
 *
 *          switch(col) {
 *             case 0:
 *                value = entry.getWorkDate();
 *                break;
 *
 *             case 1:
 *                value = entry.getStartTime();
 *                break;
 *             ...
 *          }
 *        } catch(Exception ex) {
 *           return "";
 *       }
 *
 *       return value;
 *    }
 *
 *    ...
 * }
 * </pre>
 *
 * <p>Here is an example of non-brittle code using ObjectProxy:
 * <pre>
 * public class LogTableModel extends AbstractTableModel {
 *    ...
 *
 *    public LogTableModel() {
 *       columns = new String[] { "workDate",  "startTime", "endTime",
 *          "mealTime", "hours", "notes" };
 *       entryProxy = new ObjectProxy(LogEntry.class);
 *       ...
 *    }
 *
 *    public Object getValueAt(int row, int col) {
 *       LogEntry entry;
 *       Object   value;
 *
 *       try {
 *          entry = log.get(row);
 *          entryProxy.setTarget(entry);
 *          value = entryProxy.get(columns[col]);
 *        } catch(Exception ex) {
 *           return "";
 *       }
 *
 *       return value;
 *    }
 *
 *    ...
 * }
 * </pre>
 *
 * @author Thornton Rose
 */
public class ObjectProxy {
   private Object    obj;
   private Class     objClass;
   private Hashtable propertyDescriptors = new Hashtable();

   /**
    * Construct a proxy for objects of the given class.
    *
    * @param objClass The class of the target object.
    */
   public ObjectProxy(Class objClass) throws IntrospectionException {
      this.objClass = objClass;

      // Load hashtable of property descriptors.
      BeanInfo info = Introspector.getBeanInfo(objClass);
      PropertyDescriptor[] descriptors = info.getPropertyDescriptors();

      for (int i = 0; i < descriptors.length; i ++) {
         PropertyDescriptor pd = descriptors[i];
         propertyDescriptors.put(pd.getName(), pd);
      }
   }

   /**
    * Construct a proxy for the given object.
    *
    * @param obj The target object.
    */
   public ObjectProxy(Object obj) throws IntrospectionException {
      this(obj.getClass());
      setTarget(obj);
   }
   
   //--------------------------------------------------------------------------

   /**
    * Set the target object.
    *
    * @param obj The target object.
    */
   public void setTarget(Object obj) {
      this.obj = obj;
   }

   /**
    * Get object property.
    *
    * @param name Property name.
    *
    * @return Property value.
    */
   public Object get(String name) throws Exception {
      // Get the property descriptor.
      PropertyDescriptor pd = (PropertyDescriptor) propertyDescriptors.get(
         name);

      // If descriptor not found, throw exception.
      if (pd == null) {
         throw new NoSuchFieldException("Unknown property: " + name);
      }

      // Get the getter method.
      Method getter = pd.getReadMethod();

      // If method not found, throw exception.
      if (getter == null) {
         throw new NoSuchMethodException("No read method for: " + name);
      }

      // Invoke the getter and return the result.
      return getter.invoke(obj, new Object[] {});
   }

   /**
    * Set object property.
    *
    * @param name   Property name.
    * @param value  Property value.
    */
   public Object set(String name, Object value) throws Exception {
      // Get the property descriptor.
      PropertyDescriptor pd = (PropertyDescriptor) propertyDescriptors.get(
         name);

      // If descriptor not found, throw exception.
      if (pd == null) {
         throw new NoSuchFieldException("Unknown property: " + name);
      }

      // Get the setter method.
      Method setter = pd.getWriteMethod();

      // If method not found, throw exception.
      if (setter == null) {
         throw new NoSuchMethodException("No write method for: " + name);
      }
      
      // Invoke the setter method and return the result.
      return setter.invoke(obj, new Object[] { value } );
   }

   /**
    * Invoke object method.
    *
    * @param name       Method name.
    * @param types      Parameter types.
    * @param parameters List of parameters.
    *
    * @return Return value from method (may be null).
    *
    * @throws Exception When any exception occurs.
    */
   public Object invoke(String name, Class[] types, Object[] parameters) 
         throws Exception {
      // Get method.
      Method m = objClass.getMethod(name, types);
      
      // If method not found, throw exception.
      if (m == null) {
         throw new NoSuchMethodException("Unknown method: " + name);
      }
      
      // Invoke method.
      return m.invoke(obj, parameters);
   }
}
