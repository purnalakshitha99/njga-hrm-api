import React from 'react'
import '../css/demo.css';
import { Link } from 'react-router-dom';
// import Image from '../avatars/logo.png'


function Login() {
    const togglePasswordVisibility = () => {
        const passwordInput = document.getElementById('password');
        const icon = document.querySelector('.input-group-text i');
    
        if (passwordInput.type === 'password') {
          passwordInput.type = 'text';
          icon.className = 'bx bx-show';
        } else {
          passwordInput.type = 'password';
          icon.className = 'bx bx-hide';
        }
      };
  return (
    <div>

<div className="container">
  <div className="authentication-wrapper authentication-basic container-p-y">
    <div className="authentication-inner">
      {/* Register */}
      <div className="card " id='logincard'>
        <div className="card-body mt-50">
          <div className='mt-10'>
          {/* Logo */}
          <div className="app-brand justify-content-center ">
            <a href="index.html" className="app-brand-link gap-2">
              <div>
                <img
                  className="logo-image"
                  src={Image}
                  alt="logo"
                />
              </div>
              <span className="app-brand-text demo text-body fw-bold">
                NGJA
              </span>
            </a>
          </div>
          {/* /Logo */}
          <form id="formAuthentication" className="m-3" action="index.html">
            <div className="mb-3">
              <label htmlFor="email" className="form-label">
                NIC
              </label>
              <input
                type="text"
                className="form-control"
                id="email"
                name="email-username"
                placeholder="Enter your NIC number"
                autofocus=""
              />
            </div>
            <div className="mb-3 form-password-toggle">
              <div className="d-flex justify-content-between">
                <label className="form-label" htmlFor="password">
                  Password
                </label>
                <a href="./auth-login-basic.html">
                  <small>Forgot Password?</small>
                </a>
              </div>
              <div className="input-group input-group-merge">
          <input
            type="password"
            id="password"
            className="form-control"
            name="password"
            placeholder="············"
            aria-describedby="password"
          />
          <span
            className="input-group-text cursor-pointer"
            onClick={togglePasswordVisibility}
          >
            <i className="bx bx-hide" />
          </span>
        </div>
      </div>
            <div className="mb-3 mt-3">
              <div className="form-check">
                <input
                  className="form-check-input"
                  type="checkbox"
                  id="remember-me"
                />
                <label className="form-check-label" htmlFor="remember-me">
                  {" "}
                  Remember Me{" "}
                </label>
              </div>
            </div>
            <div className="mb-3">
              <Link to={'/lol'}><button className="btn btn-primary d-grid w-100" type="submit">
                LOGIN
              </button></Link>
            </div>
          </form>
          </div>
          <p />
        </div>
      </div>
      {/* /Register */}
    </div>
  </div>
</div>



    </div>
  )
}

export default Login