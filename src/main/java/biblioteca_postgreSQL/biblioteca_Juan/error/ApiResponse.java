package biblioteca_postgreSQL.biblioteca_Juan.error;

import java.util.Date;

public class ApiResponse {
    private Date tiempo=new Date();
    private String mensaje;
    private String url;

    public ApiResponse() {
    }

    public ApiResponse(String mensaje, String url) {
        this.mensaje = mensaje;
        this.url = url.replace("uri=","");
    }

    public Date getTiempo() {
        return tiempo;
    }

    public void setTiempo(Date tiempo) {
        this.tiempo = tiempo;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
