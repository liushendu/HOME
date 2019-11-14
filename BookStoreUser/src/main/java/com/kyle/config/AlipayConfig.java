package com.kyle.config;

public class AlipayConfig {

	public static String app_id = "2016101300680100";//�ں�̨��ȡ���������ã�
	
	public static String merchant_private_key = "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQDAxL2shLmQFOCIVhR/ofK89roPE6Kp1C4FQ8u+z/RcI/zJFPt68GBNWE9lbTFxGK4kjmCT6g6s/4VZqvQc8kIE3D16hGAKTNc/Z3W9o3YFq8OqEL/xod+vwZ+4XHdOmbG5wBy4tv3ITEjwFp9XwLMPZL8Oh6b4fU04O2BQ6UKkTy71QLKr0xJH52wAAkzGy1LBZ2Kbrv3UxsgZazoVX2EhbexsRuXfLkMLxdGGErHI7cX3bX4brGF61FlqOlWpwGm9brdUrJ/sUH+p4sT3vWZuSyR1FD1lvkOPTdt+GaoPuCJUkvs/6BtcCWVN0wCNGg2psNystJk3UCrMr+4ZZ43dAgMBAAECggEAB2CAEbYSk9z4qr8AkdHUxD586E7MDsu75x+tEGRM6anG5rsS1KWWSd9zSmJfXgCfyW5Za8+tOBmfNMtCBEmRFTaIc8PVGQ/PvPFspBE5VwY3uq5hahHTyZoTTq7bMfrXvlAHyVnXZG7m66kx9927/H7SgO/YB/Jjnh9HlFEY58i+5vibiNoKUD2GfBSvCOJrKXe9GrbysUmLHjeDZbDcMDhjGO97rBhFlQlRcKTDBqJEOjfAj/p0Q1bxfE6rkFvrCNDx6QKZhj5FtiddBCvBczqUKRMbeubKoPlgAA7tTw7YP9kxXH2CqltSsldPjQwcDv/Gs1vK7OivmqtPGxD+0QKBgQDxzbLwSE8x31/krdrkkhV7HisWSdqWTv8Mnws/oCv5KAxkJRf/YJlIrxPv0doBCva/cJ06PuZp4cI14fpTcMhHV649lK9jbr5TGLVQQq48k+0PtqjAwVXgPEZZR9Q4KJLSntVXKW3jR5k+OX+DYM6R+CG3OISXlmt9SKbZjffP0wKBgQDMFgwTFPZIstrzWtAfXp2/j1dkKJYzPKvtUHXch4w46P2R8S2dC3LrHyegLUKF7tQHSzRr5xS+QPXh35vjSpQqFIDpbDyr3lt3pkySJuTxnLZVsqdzC+HnOh9/na3UGVmkxLNPZjW2QY5CQ+Q9cVTC099oGBEmtioJChEQoKhNjwKBgDu91rgHJYns5oRZb/uJHEWO7pZTKO56FgnIQb82k6a7flQ/1e4Cr9yFZSebcYFQdCZYbIA3ijYe0Rz++Bolg1YdE6+jTLIEaoGdWS67StEsuyVmu8rj+ZOtULQ+SvCVFbF0DMG8Oqosxm/ZROfwwxjNdYcPL7NENsp9aLvXl6KBAoGAXblOSEEbLZ29wX6WD6HzDfL1LlEZUWRujGikB+fT9JrDQI+i4/lLCEFhgEToxPs+Mi9OXrNbqlfI07dOLt6kFoMeBJSpdECEfvlHNuNXxsGyVr7Z+ZKeZwMhTgkKuFn/+hQ/SJpm1lFa1IG7QqBWTbbhZTuQPNfxi/8sgRdW028CgYAhsZazKG19cahk2YGpFPLWq/XJtrMViE0M0BTNA1AScgJgLXoblscahn1OCWuKhGZl7Q4Akcd1zTIvqH2DcP4IIcWSYCBOe6JRFW2G6OQnLCrZroSQi3X9n1+9wFrxwjzFuz8j6oKB9VXOJwbkzzaNiCgOxQEpRfS58AH3smD6Uw==";//�̳̲鿴��ȡ��ʽ���������ã�

	public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAzq4VmbZk23zNIeKoYj+z5OpeQT9ZnpGVQDN0AYM7/RydHbWOSQcH+C4zdtBNJT4SIRV0XrHsHV+xQnaiBntsryeVcmFeQUFDgHVtHRp4Ocx1PjOJZ3nRk4iBnTSp7iGAmN2qnoQvC5WUOBoixWOOMVDH6DqN/WVloTZLjBkZ3Qesqy1wQ2YR4vO8jJsGNwixKnsq8kTkK2AsZwOCtibRGO+0R8PMH/HOq0V2L07ovS7K7T92KagHsxdeJg3qiDIekXo4V0Gzf5a7MHAGsdshQ2I4cc2rUWuoTPAneuHLtOwIUflZY7F+J3cnHKptdCxFSTBCzEiomADc2TQNfFtgTwIDAQAB";//�̳̲鿴��ȡ��ʽ���������ã�
	
	public static String notify_url = "http://localhost:8080/#/payment";
	
	public static String return_url = "http://localhost:8080/#/payment";
	
	public static String sign_type = "RSA2";
	
	public static String charset = "utf-8";
	
	public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";//ע�⣺ɳ����Ի�������ʽ����Ϊ��https://openapi.alipay.com/gateway.do
}
