import React, { createContext, useState, useContext, type ReactNode } from "react";

interface User {
  username: string;
  role: "admin" | "worker";
}

interface AuthContextType {
  user: User | null;
  setUser: (user: User | null) => void;
}

const AuthContext = createContext<AuthContextType>({
  user: null,
  setUser: () => {},
});

interface AuthProviderProps {
  children: ReactNode;
}

export function AuthProvider({ children }: AuthProviderProps) {
  const storedUser = localStorage.getItem("user");
  const [user, setUserState] = useState<User | null>(
    storedUser ? JSON.parse(storedUser) : null
  );

  const setUser = (newUser: User | null) => {
    if (newUser) {
      localStorage.setItem("user", JSON.stringify(newUser));
      setUserState(newUser);
    } else {
      localStorage.removeItem("user");
      setUserState(null);
    }
  };

  return React.createElement(
    AuthContext.Provider,
    { value: { user, setUser } },
    children
  );
}

export function useAuth() {
  return useContext(AuthContext);
}
