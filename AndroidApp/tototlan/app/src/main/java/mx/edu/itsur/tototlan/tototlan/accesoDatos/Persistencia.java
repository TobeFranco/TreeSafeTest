package mx.edu.itsur.tototlan.tototlan.accesoDatos;

import mx.edu.itsur.tototlan.tototlan.modelo.Student;

public class Persistencia {

    /* Para obtener un objeto con la funcionalidad de persistencia a la base de datos.
     * Ejemplo:
     * AlumnoDao basedatos = Persistencia.obtenerObjetoAccesoDatos(Alumno){
     *
     */
    public static GenericoDAO obtenerObjetoAccesoDatos(Class entidad ){

        if(entidad.getClass().isInstance(Student.class)){
            return new StudentSQliteDAO();
        }

        /*if(entidad.getClass().isInstance(Alumno.class)){
            return new AlumnoSQliteDAO();
        }*/
        return null;
    }



}
