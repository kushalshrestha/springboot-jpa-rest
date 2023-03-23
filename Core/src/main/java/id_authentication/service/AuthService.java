package id_authentication.service;

import id_authentication.DTOLogin.LoginRequestDTO;
import id_authentication.DTOLogin.LoginResponseDTO;
import id_authentication.DTOLogin.RefreshTokenRequestDTO;

public interface AuthService {

    LoginResponseDTO login(LoginRequestDTO loginRequestDTO);
    LoginRequestDTO refreshToken(RefreshTokenRequestDTO refreshTokenRequestDTO);
}
