package com.singtel.systempayment.java.controllers;

import com.google.zxing.WriterException;
import com.singtel.systempayment.java.Generator.QRCodeGenerator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;
import java.util.Base64;

@Controller
public class QRCodeController {

    private static final String QR_CODE_IMAGE_PATH = "./src/main/resources/static/img/QRCode.png";

    @GetMapping("/")
    public String getQRCode(Model model){
        String medium="https://github.com/rakbar94/SystemPaymentSingtel/";
        String github="https://github.com/rakbar94/SystemPaymentSingtel";

        byte[] image = new byte[0];
        try {

            // Generate and Return Qr Code in Byte Array
            image = QRCodeGenerator.getQRCodeImage(medium,250,250);

            // Generate and Save Qr Code Image in static/image folder
            QRCodeGenerator.generateQRCodeImage(github,250,250,QR_CODE_IMAGE_PATH);

        } catch (WriterException | IOException e) {
            e.printStackTrace();
        }
        // Convert Byte Array into Base64 Encode String
        String qrcode = Base64.getEncoder().encodeToString(image);

        model.addAttribute("medium",medium);
        model.addAttribute("github",github);
        model.addAttribute("qrcode",qrcode);

        return "qrcode";
    }
}