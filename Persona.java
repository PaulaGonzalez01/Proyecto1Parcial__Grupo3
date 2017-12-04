
package registroharrypotter;

public class Persona {
    
    public String nombre;
    public String apellido;
    public int edad;
    public String casa;
    public String varita;

    public Persona(String nombre, String apellido, int edad, String casa, String varita) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.casa = casa;
        this.varita = varita;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setCasa(String casa) {
        this.casa = casa;
    }

    public void setVarita(String varita) {
        this.varita = varita;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public int getEdad() {
        return edad;
    }

    public String getCasa() {
        return casa;
    }

    public String getVarita() {
        return varita;
    }
    
    

}
