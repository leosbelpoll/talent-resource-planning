import { useState, useEffect } from "react";
import { useLocation } from "react-router-dom";

export default function useLogged() {
    const [logged, setLogged] = useState();
    let location = useLocation();

    useEffect(() => {
        setLogged(localStorage.getItem("isLogged"));
    }, [location]);

    return logged;
}
