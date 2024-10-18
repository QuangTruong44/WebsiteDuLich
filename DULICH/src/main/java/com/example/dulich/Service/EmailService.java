package com.example.dulich.Service;


public interface EmailService {
    void SendFilePDF(String to, byte[] fileBytes);
}
