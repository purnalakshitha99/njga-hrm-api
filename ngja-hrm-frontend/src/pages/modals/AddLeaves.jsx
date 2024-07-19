import React from 'react'
import '../../css/AddLeaves.css'

function AddLeaves() {
    return (
        <div>
            <div className="row">
                <div className="col-xl">
                    <div className="card mb-4">
                        <div className="card-header d-flex justify-content-between align-items-center">
                        </div>
                        <div className="card-body">
                            <form>
                                <div className="mb-3">
                                    <label className="form-label" htmlFor="basic-default-fullname">
                                        Type
                                    </label>

                                    <div>
                                        <select
                                            className="form-select "

                                            aria-label="Default select example"
                                        >
                                            <option selected="">Leave Type</option>
                                            <option value={1}>Half-day</option>
                                            <option value={2}>Short-Leave</option>
                                            <option value={3}>Gate pass</option>
                                        </select>
                                    </div>

                                        <div className='row timep'>
                                            <div className='col'>
                                            <div className="mb-3 row">
                                        <label htmlFor="html5-time-input" className="col-md-2 col-form-label">
                                            Time
                                        </label>
                                        <div className="col-md-10">
                                            <input
                                                className="form-control"
                                                type="time"
                                                defaultValue="12:30:00"
                                                id="html5-time-input"
                                            />
                                        </div>
                                    </div>
                                            </div>
                                            <div className='col'>
                                            <div className="mb-3 row">
                                        <label htmlFor="html5-time-input" className="col-md-2 col-form-label">
                                            Time
                                        </label>
                                        <div className="col-md-10">
                                            <input
                                                className="form-control"
                                                type="time"
                                                defaultValue="12:30:00"
                                                id="html5-time-input"
                                            />
                                        </div>
                                    </div>
                                            </div>
                                        </div>
                                    

                                    {/* <input
              type="text"
              className="form-control"
              id="basic-default-fullname"
              placeholder="John Doe"
            />
          </div>
          <div className="mb-3">
            <label className="form-label" htmlFor="basic-default-company">
              Company
            </label>
            <input
              type="text"
              className="form-control"
              id="basic-default-company"
              placeholder="ACME Inc."
            />
          </div>
          <div className="mb-3">
            <label className="form-label" htmlFor="basic-default-email">
              Email
            </label>
            <div className="input-group input-group-merge">
              <input
                type="text"
                id="basic-default-email"
                className="form-control"
                placeholder="john.doe"
                aria-label="john.doe"
                aria-describedby="basic-default-email2"
              />
              <span className="input-group-text" id="basic-default-email2">
                @example.com
              </span>
            </div>
            <div className="form-text">
              You can use letters, numbers &amp; periods
            </div>
          </div>
          <div className="mb-3">
            <label className="form-label" htmlFor="basic-default-phone">
              Phone No
            </label>
            <input
              type="text"
              id="basic-default-phone"
              className="form-control phone-mask"
              placeholder="658 799 8941"
            /> */}
                                </div>
                                <div className="mb-3">
                                    <label className="form-label" htmlFor="basic-default-message">
                                        Message
                                    </label>
                                    <textarea
                                        id="basic-default-message"
                                        className="form-control"
                                        placeholder="Type the Reason Here"
                                        defaultValue={""}
                                    />
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>

        </div>
    )
}

export default AddLeaves