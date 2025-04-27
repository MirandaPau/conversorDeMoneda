import java.util.Map;

public record Moneda(
        String base_code,
        String target_code,
        Map<String, Double> conversion_rates) {


}
