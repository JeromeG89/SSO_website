import { useAuth } from "../context/AuthContext";

export default function AdminDashboard() {
  const { user } = useAuth();
  return (
    <div style={{ padding: "20px" }}>
      <h2>Admin Dashboard</h2>
      <p>Welcome {user?.username}</p>
      <p>Analytics & job creation will go here</p>
    </div>
  );
}
