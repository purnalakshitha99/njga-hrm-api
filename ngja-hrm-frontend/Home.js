import React, { useEffect } from "react";
import "../css/sidebar.css";
import { Collapse } from "bootstrap";
import NavBar from "../component/NavBar";
import Sidebar from "../component/Sidebar";
import "../css/home.css";
import Footer from "../component/Footer";

export default function NewSidebar() {
  useEffect(() => {
    const body = document.querySelector("body");
    const sidebar = body.querySelector("nav");
    const toggle = body.querySelector(".toggle");

    const toggleSidebar = () => {
      sidebar.classList.toggle("close");
    };

    toggle.addEventListener("click", toggleSidebar);

    return () => {
      toggle.removeEventListener("click", toggleSidebar);
    };
  }, []);

  useEffect(() => {
    const section = document.querySelector(".home");
    let startX, startY;

    const startDrag = (e) => {
      e.preventDefault();
      startX = e.clientX - section.getBoundingClientRect().left;
      startY = e.clientY - section.getBoundingClientRect().top;
      document.addEventListener("mousemove", drag);
      document.addEventListener("mouseup", endDrag);
    };

    const drag = (e) => {
      e.preventDefault();
      const x = e.clientX - startX;
      const y = e.clientY - startY;
      section.style.left = x + "px";
      section.style.top = y + "px";
    };

    const endDrag = () => {
      document.removeEventListener("mousemove", drag);
      document.removeEventListener("mouseup", endDrag);
    };

    section.addEventListener("mousedown", startDrag);

    return () => {
      section.removeEventListener("mousedown", startDrag);
    };
  }, []);

  return (
    <div>
      <>
        <div className="layout-wrapper layout-content-navbar">
          <div className="layout-container">
            <Sidebar />
            <section className="home">
              <div className="content ">
                <div style={{ paddingRight: "300px" }}>
                  <NavBar />

                  <div className="mt-4 mb-4">
                    <h1>Dashboard</h1>
                  </div>

                  <div className="content-body">
                  
                  </div>

                  <div>
                   <Footer/>
                  </div>

                </div>
              </div>
            </section>
          </div>
        </div>
      </>
    </div>
  );
}
