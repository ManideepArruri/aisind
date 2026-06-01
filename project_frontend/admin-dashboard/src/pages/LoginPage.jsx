import { useState } from "react";
import { useNavigate } from "react-router-dom";
import api from "../services/api";
import "./LoginPage.css";
import logo from "../assets/logo.png";

export default function LoginPage() {

  const navigate = useNavigate();

  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");

  const login = async (e) => {
    e.preventDefault();

    try {
      const response = await api.post(
        "/auth/login",
        {
          email,
          password
        }
      );

      localStorage.setItem("token", response.data.token);
      localStorage.setItem("role", response.data.role);
      localStorage.setItem("email", response.data.email);

      if (response.data.role === "ADMIN") {
        navigate("/dashboard");
      }
      else if (response.data.role === "MANAGER") {
        navigate("/dashboard/manager");
      }
      else {
        navigate("/dashboard/user");
      }

    } catch (error) {
      alert("Invalid Credentials");
    }
  };

  return (
    <div className="login-container">
      <div className="login-left">
        <div className="login-card">
          <div className="login-header">
            <img src={logo} alt="PRMP Logo" className="login-logo" />
            <h1 className="login-title">PRMP</h1>
          </div>
          <p className="login-subtitle">AI-Powered Project Intelligence Platform</p>
          
          <form onSubmit={login} className="login-form">
            <div className="form-group">
              <label htmlFor="email">Email Address</label>
              <input
                id="email"
                type="email"
                placeholder="Enter email"
                value={email}
                onChange={(e) => setEmail(e.target.value)}
                required
              />
            </div>
            
            <div className="form-group">
              <label htmlFor="password">Password</label>
              <input
                id="password"
                type="password"
                placeholder="Enter password"
                value={password}
                onChange={(e) => setPassword(e.target.value)}
                required
              />
            </div>
            
            <button type="submit" className="login-button">
              Sign In
            </button>
          </form>
        </div>
      </div>
      
      <div className="login-right">
        <div className="right-overlay">
          <h2>Predictive Project Intelligence</h2>
          <p>
            Gain real-time insights, analyze team member utilization heatmaps, calculate sprint velocity trends, and predict project delays using AI.
          </p>
        </div>
      </div>
    </div>
  );
}