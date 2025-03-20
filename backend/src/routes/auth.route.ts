import { Request, Response, Router } from "express";
import { Login } from "../controllers/auth.controller";

const router = Router();
router.post("/login", (req: Request, res: Response) => Login(req, res));
export default router;