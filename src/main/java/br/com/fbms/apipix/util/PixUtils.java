package br.com.fbms.apipix.util;

public class PixUtils {

    public static String gerarPixCopiaECola(String chavePix, String nomeRecebedor, String cidade, String valor, String txid) {
        String payloadFormatIndicator = "000201";
        String merchantAccountInfo = montarMerchantAccountInfo(chavePix);
        String merchantCategoryCode = "52040000";
        String transactionCurrency = "5303986";
        String transactionAmount = "54" + formatarCampo(valor);
        String countryCode = "5802BR";
        String merchantName = "59" + formatarCampo(nomeRecebedor);
        String merchantCity = "60" + formatarCampo(cidade);
        String additionalDataField = montarAdditionalData(txid);

        String payloadSemCRC = payloadFormatIndicator +
                merchantAccountInfo +
                merchantCategoryCode +
                transactionCurrency +
                transactionAmount +
                countryCode +
                merchantName +
                merchantCity +
                additionalDataField +
                "6304"; // campo do CRC (valor será calculado)

        String crc16 = calcularCRC16(payloadSemCRC);
        return payloadSemCRC + crc16;
    }

    private static String montarMerchantAccountInfo(String chave) {
        String gui = "br.gov.bcb.pix";
        String guiField = "00" + formatarCampo(gui);
        String chaveField = "01" + formatarCampo(chave);
        String full = "26" + formatarCampo(guiField + chaveField);
        return full;
    }

    private static String montarAdditionalData(String txid) {
        String txidField = "05" + formatarCampo(txid);
        String full = "62" + formatarCampo(txidField);
        return full;
    }

    private static String formatarCampo(String valor) {
        return String.format("%02d%s", valor.length(), valor);
    }

    private static String calcularCRC16(String payload) {
        int polinomio = 0x1021;
        int resultado = 0xFFFF;

        byte[] bytes = payload.getBytes();
        for (byte b : bytes) {
            resultado ^= (b & 0xFF) << 8;
            for (int i = 0; i < 8; i++) {
                if ((resultado & 0x8000) != 0) {
                    resultado = (resultado << 1) ^ polinomio;
                } else {
                    resultado <<= 1;
                }
                resultado &= 0xFFFF;
            }
        }

        return String.format("%04X", resultado);
    }
}
