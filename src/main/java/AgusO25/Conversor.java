package AgusO25;
public class Conversor {
    private String codigoBase;
    private String codigoTarjeta;
    private Double conversion;
    private String resultado;


    public String getCodigoBase() {
        return codigoBase;
    }
    public void setCodigoBase(String codigoBase) {
        this.codigoBase = codigoBase;
    }
    public String getCodigoTarjeta() {
        return codigoTarjeta;
    }
    public void setCodigoTarjeta(String codigoTarjeta) {
        this.codigoTarjeta = codigoTarjeta;
    }
    public Double getConversion() {
        return conversion;
    }
    public void setConversion(Double conversion) {
        this.conversion = conversion;
    }
    public String getResultado() {
        return resultado;
    }
    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public String obtenerElSimbolo(String codigoMoneda){
        return switch (codigoMoneda){
            case "USD" -> "$";  // Estadounidense
            case "CLP" -> "$"; // Chileno
            case "ARS" -> "$"; // Argentino
            case "EUR" -> "€"; // Euro
            case "BRL" -> "$"; // Brasileño
            default -> codigoMoneda;
        };
    }

    public String mostrarResultado(double monto) {
        String simboloOrigen = obtenerElSimbolo(codigoBase);
        String simboloDestino = obtenerElSimbolo(codigoTarjeta);
        return simboloOrigen + monto + " " + codigoBase + " equivalen a " +
               simboloDestino + String.format("%.2f", monto * conversion) + " " + codigoTarjeta +
                "\nTasa de conversión: " + String.format("%.2f", conversion);
    }


    @Override
    public String toString() {
        return "Conversor{" +
                "Moneda origen ='" + codigoBase + '\'' +
                ", Moneda destino ='" + codigoTarjeta + '\'' +
                ", Tasa conversión =" + conversion +
                ", Resultado ='" + resultado + '\'' +
                '}';
    }

}
