import Sidebar from "../components/Sidebar";

function MainLayout({ children }) {

    return (
        <div>

            <Sidebar />

            <div
                style={{
                    marginLeft: "250px",
                    padding: "30px"
                }}
            >
                {children}
            </div>

        </div>
    );
}

export default MainLayout;