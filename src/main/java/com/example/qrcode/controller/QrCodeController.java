package com.example.qrcode.controller;

import com.example.qrcode.service.QrCodeGenerator;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Base64;

@RestController
@RequestMapping("/api/qr-code")
@RequiredArgsConstructor
public class QrCodeController {

    private final QrCodeGenerator qrCodeGenerator;

    private static final String MY_GITHUB = "https://github.com/oguzhanyildiz22";
    //private static final String QR_CODE_IMAGE_PATH = "./src/main/resources/static/img/QRCode.png";

    @GetMapping("get")
    public void getQrCode(HttpServletResponse response) throws IOException, WriterException {

        response.setContentType("image/png");
        BufferedImage bufferedImage = qrCodeGenerator.generateQrCodeImageToShowImage(MY_GITHUB,250,250);
        ImageIO.write(bufferedImage,"PNG",response.getOutputStream());

    }
    
}
