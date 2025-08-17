import { useAuth } from "../context/AuthContext";

export default function WorkerDashboard() {
  const { user } = useAuth();
  return (
    <div style={{ padding: "20px" }}>
      <h2>Worker Dashboard</h2>
      <p>Welcome {user?.username}</p>
      <p>Job list will go here</p>
    </div>
  );
}
