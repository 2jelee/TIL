import { Navigate } from 'react-router';
import { useLocation } from 'react-router-dom';
import { CheckToken } from "../utils/TokenUtil";
import LoadingModal from "../components/common/LoadingModal";


export default function PublicRoute({ children }) {
    const location = useLocation();
    const { isAuth } = CheckToken(location.key);

    console.log("isAuth : "+isAuth) //failed
    if (isAuth === 'Success') {
        return (
            <Navigate to="/" state={{from: location}}/>
        )
    } else if (isAuth === 'Loading') {
        return <LoadingModal />
    }
    console.log("else에서 걸림");
    console.log(children); // undefined

    return children;
}
