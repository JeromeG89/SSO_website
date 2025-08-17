
import { useAuth } from "../context/AuthContext";
import { useNavigate } from "react-router-dom";
import { useState } from "react";

export default function LoginPage() {
  const { setUser } = useAuth();
  const navigate = useNavigate();
  const [username, setUsername] = useState("");
  const [role, setRole] = useState<"admin" | "worker">("worker");

  const handleLogin = () => {
    setUser({ username, role });
    navigate(`/${role}`);
  };

  return (
    <div style={{ padding: "20px" }}>
      <h2>Login</h2>
      <input
        placeholder="Enter name"
        value={username}
        onChange={(e) => setUsername(e.target.value)}
      />
      <select value={role} onChange={(e) => setRole(e.target.value as any)}>
        <option value="worker">Worker</option>
        <option value="admin">Admin</option>
      </select>
      <button onClick={handleLogin}>Login</button>
    </div>
  );
}
