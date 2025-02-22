package com.example.dulich.Api;

import com.example.qldl.Entity.AccountEntity;
import com.example.qldl.Service.AccountService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/account-api")
public class AccountApi {
    @Autowired
    private AccountService accServ;

    @GetMapping("/getAllAccount")
    public ResponseEntity<?> doGetAllAccount() {
        Map<String, Object> result = new HashMap<>();
        try {
            result.put("status", true);
            result.put("message", "Get All Account Success");
            result.put("data", accServ.getAllAccount());
        } catch (Exception e) {
            result.put("status", false);
            result.put("message", "Get All Account Fail");
            result.put("data", null);
            log.error("Fail When Call API /java05/account-api/getAllAccount ", e);
        }
        return ResponseEntity.ok(result);
    }

    @PostMapping("/login")
    public ResponseEntity<?> doGetLogin(@RequestBody AccountEntity accountEntity,
                                        final HttpServletRequest request) {
        Map<String, Object> result = new HashMap<>();
        try {
            var data = accServ.getAccountByTk(accountEntity.getAccountName());
            if (!data.isEmpty()) {
                result.put("status", true);
                result.put("message", "Login Success");
                result.put("data", data.get().getAccountName());
                HttpSession session = request.getSession();
                session.setAttribute("role", data.get().getRole().getRole_name());
            } else {
                result.put("status", false);
                result.put("message", "Login Fail");
            }
        } catch (Exception e) {
            result.put("status", false);
            result.put("message", "Login Fail");
            result.put("data", null);
            log.error("Fail When Call API /accountApi/login ", e);
        }
        return ResponseEntity.ok(result);
    }

    @PostMapping("/addAccount")
    public ResponseEntity<?> doPostAddAccount(@RequestBody AccountEntity accountEntity) {
        Map<String, Object> result = new HashMap<>();
        try {
            result.put("status", true);
            result.put("message", "Get All Account Success");
            result.put("data", accServ.doSaveAccount(accountEntity));
        } catch (Exception e) {
            result.put("status", false);
            result.put("message", "Get All Account Fail");
            result.put("data", null);
            log.error("Fail When Call API /java05/account-api/getAllAccount ", e);
        }
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/DeleteId")
    public ResponseEntity<?> doDeleteUserId(@RequestParam("userId") int userId) {
        Map<String, Object> result = new HashMap<>();
        try {
            result.put("success", true);
            result.put("message", "Call Api Success");
            accServ.doDeleteById(userId);
        } catch (Exception e) {
            result.put("success", false);
            result.put("message", "Call Api Error");
            result.put("data", null);
            System.out.println(e);
        }
        return ResponseEntity.ok(result);
    }

    @GetMapping("/admin/item")
    public ResponseEntity<?> doGetItem(AccountEntity account) {
        Map<String, Object> kq = new HashMap<>();
        try {
            var data = accServ.getAccountByTk(account.getAccountName());
            if (!data.isEmpty()) {
                kq.put("status", true);
                kq.put("message", "Login Success");
                kq.put("data", data);
            } else {
                kq.put("status", false);
                kq.put("message", "Login Fail");
            }
        } catch (Exception e) {
            kq.put("status", false);
            kq.put("message", "Login Fail");
            kq.put("data", null);
            log.error("Fail When Call API /accountApi/login ", e);
        }
        return ResponseEntity.ok(kq);
    }

    @GetMapping("/getUserByUserId")
    public ResponseEntity<?> doGetUserByUserId(@RequestParam("userId") int userId) {
        Map<String, Object> result = new HashMap<>();
        try {
            result.put("status", true);
            result.put("message", "Get All Account Success");
            result.put("data", accServ.getAccountByUserId(userId));
        } catch (Exception e) {
            result.put("status", false);
            result.put("message", "Get All Account Fail");
            result.put("data", null);
            log.error("Fail When Call API /java05/account-api/getUserByUserId ", e);
        }
        return ResponseEntity.ok(result);
    }

}